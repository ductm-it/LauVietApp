

<?php
	require_once('connect.php');
	mysqli_set_charset($conn,'utf8');


        $user_name = $_POST['user_name'];
        $password =$_POST['password'];
        $email = $_POST['email'];
        $phone = $_POST['phone'];
        $address = $_POST['address'];
        $quyen = $_POST['quyen'];        
        
        // $user_name = 'AnhThuy';
        // $password ='123';
        // $email = 'anh@gmail.com';
        // $phone = '123456789';
        // $address = 'Dai Loc';
        // $quyen = 'khachhang';   
  
    
        $sqlInsert = "INSERT INTO account(user_id,user_name,password,email,phone,address,quyen) 
                VALUES(null,'$user_name','$password','$email','$phone','$address','$quyen')";
        $resultInsert = mysqli_query($conn, $sqlInsert);
        if ($resultInsert) {
            $id=$conn->insert_id;
            echo  $id;         

        } else {
           echo'that bai';
        }
            
      
        
    
	
?>

