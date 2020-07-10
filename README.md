# Lẩu Việt App
## Giới thiệu về app
### Hoàn cảnh: 
* Ứng dụng tạo ra để giúp cho mọi người mua hàng mà ở đây là lẩu. 
* App được viết trên ngôn ngữ Java kết hợp với cơ sở dữ liệu MySql.
## Cách cài đặt
### Cấu trúc file: có 2 App là Admin và Client
* File SQL bao gồm thành phần bảng và dữ liệu có sẵn về các món ăn.
* File PHP dùng để thực hiện việc nhận dữ liệu từ code Java sau đó xử lí và đưa xuống cơ sở dữ liệu MySql.
* File Java là code để thể hiện ứng dụng trên môi trường OS Android.
### Cài đặt:
* Bước 1: tải, cài đặt xampp, Android Studio trên máy tính theo đường 		link: 
	* Xampp: https://www.apachefriends.org/download.html
	* Android Studio: https://developer.android.com/studio
	* Một ứng dụng khác có thể sử dụng để cài đặt emulator nữa đó là Genymotion: [https://www.genymotion.com/download/](https://www.genymotion.com/download/)
* Bước 2: 
	* Trong mỗi App đều có 2 phần là code Java và code PHP.
	* Đối với App Admin sẽ có serveradmin và đối với App Client sẽ có serverclient.
	* Sau đó ta sẽ copy 2 folder này vào nơi cài đặt xampp trước đó.
	* Tìm đến xampp -> htdocs sau đó dán 2 folder vào htdocs.
* Bước 3:  Sau khi đã cài xong các phần mềm thì ta bắt đầu cài đặt ứng dụng (MySQL).
	* Đầu tiên ta bật xampp lên và start 2 module Apache và MySql. Có 2 thông số mà ta thấy được là PID(s) và Port. Ở đây ta chỉ cần lưu ý phần port của Apache(có 2 số ta sẽ nhớ số đầu tiên)
	* Ở mục MySql ta chọn Admin, sau đó sẽ xuất hiện trang Phpmyadmin.
	* Thực hiện việc tạo cơ sở dữ liệu với tên và định dạng là utf8_general_ci.
	* Sau khi tạo ra cơ sở dữ liệu mới ta thực hiện việc import file sql có sẵn vào cơ sở dữ liệu.
* Bước 4: Trong Android Studio
	* Sau khi có cơ sở dữ liệu đã tạo bước kế tiếp ta sẽ mở Android Studio.
	* Khi Build thành công sẽ có 3 file quan trọng: AndroidManifest, java, res.
	* Trong file java ta tìm đến mục đầu tiên -> chọn tiếp đến mục Ultil -> server.
	* Sau đó ta sẽ lấy địa chỉ Ip của máy tính hiện tại.
	* Ở dòng localhost ta sẽ sửa địa chỉ Ip lại cho đúng với địa chỉ của máy, port đúng với port của Apache.
* Bước 5: 
	* Vào lại file serveradmin và serverclient tìm đến connect.php.
	* Sau đó sửa lại tên cơ sở dữ liệu trùng với cơ sở dữ liệu đã tạo ở bước 3.
* Bước 6: Quay lại Android Studio và Run 'app'.
*Chú ý: Cả 2 máy phải chung một mạng
