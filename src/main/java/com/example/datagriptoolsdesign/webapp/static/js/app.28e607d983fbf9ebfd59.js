webpackJsonp([1],{NHnr:function(e,t,n){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var o=n("7+uW"),r={render:function(){var e=this.$createElement,t=this._self._c||e;return t("div",{attrs:{id:"app"}},[t("router-view")],1)},staticRenderFns:[]};var a=n("VU/8")({name:"App"},r,!1,function(e){n("UVTW")},null,null).exports,i=n("/ocq"),s={render:function(){var e=this.$createElement;return(this._self._c||e)("div",[this._v("\n  Hello World!\n")])},staticRenderFns:[]};var l=n("VU/8")({name:"AppIndex"},s,!1,function(e){n("PkaF")},"data-v-571787d8",null).exports,u={name:"Login",data:function(){return{loginForm:{username:"",password:""},responseResult:[]}},methods:{login:function(){var e=this,t=this;console.log(this.$store.state),this.$axios.post("/login",{username:this.loginForm.username,password:this.loginForm.password}).then(function(n){if(200===n.data.code){t.$store.commit("login",t.loginForm);var o=e.$route.query.redirect;e.$router.replace({path:"/"===o||void 0===o?"/index":o})}else e.$message.error("用户名或密码错误")}).catch(function(t){e.$message.error("服务器连接错误")})}}},c={render:function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("body",{attrs:{id:"poster"}},[n("el-form",{staticClass:"login-container",attrs:{"label-position":"left","label-width":"0px"}},[n("h3",{staticClass:"login_title"},[e._v("系统登录")]),e._v(" "),n("el-form-item",[n("el-input",{attrs:{type:"text","auto-complete":"off",placeholder:"账号"},model:{value:e.loginForm.username,callback:function(t){e.$set(e.loginForm,"username",t)},expression:"loginForm.username"}})],1),e._v(" "),n("el-form-item",[n("el-input",{attrs:{type:"password","auto-complete":"off",placeholder:"密码"},model:{value:e.loginForm.password,callback:function(t){e.$set(e.loginForm,"password",t)},expression:"loginForm.password"}})],1),e._v(" "),n("el-form-item",{staticStyle:{width:"100%"}},[n("el-button",{staticStyle:{width:"100%",background:"#505458",border:"none"},attrs:{type:"primary"},on:{click:e.login}},[e._v("登录")])],1)],1)],1)},staticRenderFns:[]};var d=n("VU/8")(u,c,!1,function(e){n("VHNv")},null,null).exports,m={name:"NavMenu",data:function(){return{navList:[{name:"/index",navItem:"首页"},{name:"/admin",navItem:"个人中心"}]}},methods:{logout:function(){console.log(this.$store.state),this.$store.commit("logout")}}},p={render:function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("el-menu",{staticStyle:{"min-width":"1300px"},attrs:{"default-active":"/index",router:"",mode:"horizontal","background-color":"white","text-color":"#222","active-text-color":"red"}},[e._l(e.navList,function(t,o){return n("el-menu-item",{key:o,attrs:{index:t.name}},[e._v("\n    "+e._s(t.navItem)+"\n  ")])}),e._v(" "),n("a",{staticStyle:{color:"#222",float:"right",padding:"20px"},attrs:{href:"login"},on:{click:e.logout}},[e._v("注销")]),e._v(" "),n("i",{staticClass:"el-icon-menu",staticStyle:{float:"right","font-size":"45px",color:"#222","padding-top":"8px"}}),e._v(" "),n("span",{staticStyle:{position:"absolute","padding-top":"20px",right:"43%","font-size":"20px","font-weight":"bold"}},[e._v("Data Grip Tools")])],2)},staticRenderFns:[]};var f={name:"Home",components:{NavMenu:n("VU/8")(m,p,!1,function(e){n("l9Dd")},"data-v-1c77806e",null).exports}},v={render:function(){var e=this.$createElement,t=this._self._c||e;return t("div",[t("nav-menu"),this._v(" "),t("router-view")],1)},staticRenderFns:[]};var h=n("VU/8")(f,v,!1,function(e){n("mvc2")},"data-v-18bdbeeb",null).exports;o.default.use(i.a);var g=new i.a({mode:"history",routes:[{path:"/home",name:"Home",component:h,redirect:"/index",children:[{path:"/index",name:"AppIndex",component:l,meta:{requireAuth:!0}}]},{path:"/login",name:"Login",component:d}]}),w=n("mvHQ"),x=n.n(w),_=n("NYxO");o.default.use(_.a);var b=new _.a.Store({state:{user:{username:null==window.localStorage.getItem("user")?"":JSON.parse(window.localStorage.getItem("user")).username}},mutations:{login:function(e,t){e.user=t,window.localStorage.setItem("user",x()(t))},logout:function(e){var t={username:"",password:""};e.user=t,window.localStorage.setItem("user",x()(t))}}}),y=n("zL8q"),F=n.n(y),$=(n("tvR6"),n("mtWM"));$.defaults.baseURL="http://localhost:8443/api",o.default.prototype.$axios=$,o.default.config.productionTip=!1,o.default.use(F.a),g.beforeEach(function(e,t,n){e.meta.requireAuth?b.state.user.username?n():n({path:"login",query:{redirect:e.fullPath}}):n()}),new o.default({el:"#app",render:function(e){return e(a)},router:g,store:b,components:{App:a},template:"<App/>"})},PkaF:function(e,t){},UVTW:function(e,t){},VHNv:function(e,t){},l9Dd:function(e,t){},mvc2:function(e,t){},tvR6:function(e,t){}},["NHnr"]);
//# sourceMappingURL=app.28e607d983fbf9ebfd59.js.map