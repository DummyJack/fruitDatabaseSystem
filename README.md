# ER-Model

![image](https://user-images.githubusercontent.com/44787477/212917478-c1e7eab8-289d-45b1-8971-5465ee011b2e.png)

# Schema

![image](https://user-images.githubusercontent.com/44787477/212917541-b0120809-872e-4ed7-b2bf-bd72d0b63bc6.png)

# 設計構思圖

![image](https://user-images.githubusercontent.com/44787477/212918162-fed67774-f578-45f9-9076-9a50a99c8f10.png)

# 使用方法

1.安裝 jdk-19

2.加入區域網，使用 ZeroTier
(Network ID:db64858fede3b884)

3.點擊 FruitDatabaseSystem.jar

4.登入使用者和密碼(user:admin, password:1234)

# 沒做到的功能

1.會員資料表的圖片必須要修改，不然修改不了會員的資料，如果沒修改會出現以下的 Error

2.日期選擇器(半完成)，需要再經過一個按鈕轉換到 JTextField 那裡

3.刪除是把資料那一筆刪掉，沒有移轉到靜止表裡面

4.水果交易資料表不會抓別的資料表裡面的資料，所以折扣後金額那一行只能自己算、無法取得水果資料表裡面的水果名稱和供應商資料表裡面的水果供應商名稱

5.平均和總和
