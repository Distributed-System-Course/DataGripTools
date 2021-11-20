<template>
  <div>
  <el-row>
    <div class="el-form-item__content">
      <el-upload ref="upload"
                 accept=".xls,.xlsx"
                 action="#"
                 :auto-upload="false"
                 :multiple="false"
                 :file-list="fileList"
                 :before-upload="beforeUpload"
                 :http-request="uploadHttpRequest"
                 :on-remove="fileRemove"
                 :on-change="fileChange">
        <el-button size="small" type="primary">选择文件</el-button>
        <div slot="tip" class="el-upload__tip">一次只能上传一个xls/xlsx文件，且不超过10M</div>
      </el-upload>
    </div>
  </el-row>
  <el-row>
    <el-button size="small" @click="closeDialog">取 消</el-button>
    <el-button type="primary" size="small" @click="submitUpload">上 传</el-button>
  </el-row>
  </div>
</template>
<script>
export default {
  name: 'Appindex',
  data () {
    return {
      fileList: []
    }
  },
  methods: {
    // 上传文件之前的钩子：判断上传文件格式、大小等，若返回false则停止上传
    beforeUpload (file) {
      // 文件类型
      const isType = file.type === 'application/vnd.ms-excel'
      const isTypeComputer = file.type === 'application/vnd.openxmlformats-officedocument.spreadsheetml.sheet'
      const fileType = isType || isTypeComputer
      if (!fileType) {
        this.$message.error('上传文件只能是xls/xlsx格式！')
      }

      // 文件大小限制为10M
      const fileLimit = file.size / 1024 / 1024 < 10
      if (!fileLimit) {
        this.$message.error('上传文件大小不超过10M！')
      }
      return fileType && fileLimit
    },
    // 自定义上传方法，param是默认参数，可以取得file文件信息，具体信息如下图
    uploadHttpRequest (param) {
      const formData = new FormData() // FormData对象，添加参数只能通过append('key', value)的形式添加
      formData.append('file', param.file) // 添加文件对象
      this.$axios.post('/upload', formData)
        .then(res => {
          const { data: { code, mark } } = res
          if (code === 0) {
            param.onSuccess() // 上传成功的文件显示绿色的对勾
            this.uploadMark = mark
          }
          return this.countData(this.uploadMark) // 根据响应的 mark 值调用统计结果接口，返回一个promise以便进行链式调用
        })
        .then(res => { // 链式调用，统计结果的响应
          const { data: { code, data } } = res
          if (code === 0) {
            console.log('统计结果', data)
          }
        })
        .catch(err => {
          console.log('失败', err)
          param.onError() // 上传失败的文件会从文件列表中删除
        })
      this.$axios.post('/AddTrace')
    },
    // 点击上传：手动上传到服务器，此时会触发组件的http-request
    submitUpload () {
      this.$refs.upload.submit()
    },
    // 文件发生改变
    fileChange (file, fileList) {
      if (fileList.length > 0) {
        this.fileList = [fileList[fileList.length - 1]] // 展示最后一次选择的文件
      }
    },
    // 移除选择的文件
    fileRemove (file, fileList) {
      if (fileList.length < 1) {
        this.uploadDisabled = true // 未选择文件则禁用上传按钮
      }
    },
    // 取消
    closeDialog () {
      this.$refs.upload.clearFiles() // 清除上传文件对象
      this.fileList = [] // 清空选择的文件列表
      this.$emit('close', false)
    }
  }
}
</script>
