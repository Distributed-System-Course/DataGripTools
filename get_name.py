from time import sleep
import pandas as pd
from selenium import webdriver


Names = []
driver = webdriver.Chrome()
driver.get("https://www.qqxiuzi.cn/zh/xingming/")
try:
    numbers = driver.find_element_by_xpath('//*[@id="num"]')
    button = driver.find_element_by_xpath('/html/body/div[3]/p[1]/input')

    print(numbers.get_property("value"))
    numbers.clear()
    numbers.send_keys("100")
    button.click()
    sleep(12)
    names = driver.find_elements_by_xpath('//*[@id="show"]/div')
    for name in names:
        Names.append(name.text)
finally:
    driver.close()
    print("获取结束")
with open("name.csv", 'w', encoding="utf-8")as f:
    f.write("Name")
    f.write("\n")

    for i in Names:
        f.write(str(i))
        f.write("\n")