import random
import openpyxl
import pandas as pd

# 读取文本文件
name = pd.read_csv("name.csv")
time = pd.read_csv("Time.csv")
id_phone = pd.read_csv("id and phone.csv")

# 获取地点信息
loca_index = []
location = ["汇丰银行", "大悦城", "中国工商银行", "万达商场"]
for i in range(101):
    loca_index.append(random.randint(0, 3))
locations = [location[i] for i in loca_index]
print(locations)
locations = pd.DataFrame(locations, columns=["location"])

exc = pd.concat([locations, time], axis = 1)
exc = pd.concat([exc, name], axis = 1)
exc = pd.concat([exc, id_phone], axis = 1)
exc.to_excel("进入登记.xlsx", index=False)
