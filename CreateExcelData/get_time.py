import datetime
import time
import random

end_time = datetime.datetime.now()
start_time = datetime.datetime.now() + datetime.timedelta(days=-10)  # 当前时间减去3分钟

a1 = tuple(start_time.timetuple()[0:9])  # 设置开始日期时间元组（2020-04-11 16:30:21）
a2 = tuple(end_time.timetuple()[0:9])  # 设置结束日期时间元组（2020-04-11 16:33:21）

start = time.mktime(a1)  # 生成开始时间戳
end = time.mktime(a2)  # 生成结束时间戳
Dates = []
# 随机生成日期字符串
for i in range(100):
    t = random.randint(start, end)  # 在开始和结束时间戳中随机取出一个
    date_touple = time.localtime(t)  # 将时间戳生成时间元组
    date = time.strftime("%Y-%m-%d %H:%M:%S", date_touple)  # 将时间元组转成格式化字符串（2020-04-11 16:33:21）
    Dates.append(date)
    print(date)
print(len(Dates))
if len(Dates) == 100:
    with open("Time.csv", "w", encoding="utf-8") as f:
        f.write("enter time")
        f.write("\n")
        for i in Dates:
            f.write(str(i))
            f.write("\n")