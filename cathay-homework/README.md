1.請執行CathayApplication

2.h2 console
	2.1 http://localhost:8080/h2-console
	2.2 JDBC URL：jdbc:h2:mem:testdb
	2.3 User Name：Cathay
	
3.coindesk API執行
	3.1 http://localhost:8080/api/getRawData 取得對方API全部資料
	3.2 http://localhost:8080/api/transformed 
		A. 更新時間（時間格式範例：1990/01/01 00:00:00）。
		B. 幣別相關資訊（幣別，幣別中文名稱，以及匯率）。
		
4.幣別的CRUD API執行
	4.1 (GET)    http://localhost:8080/api/currencies/findAll 資得資料庫全部資料
	4.2 (POST)   http://localhost:8080/api/currencies/create  新增幣別及中文名稱
	4.3 (Put) 	 http://localhost:8080/api/currencies/update/{code} 更新幣別的中文名稱
	4.4 (Delete) http://localhost:8080/api/currencies/delete/{code} 刪除資料