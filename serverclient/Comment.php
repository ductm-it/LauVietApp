<?php
       require_once('connect.php');
       mysqli_set_charset($conn,'utf8');
           $id_comment = $_POST['id_comment'];
           $id_product = $_POST['id_product'];
           $user_id = $_POST['user_id'];
           $content = $_POST['content'];
           $sqlInsert = "INSERT INTO comment (id_comment,id_product,user_id,content) VALUES (null,'$id_product','$user_id','$content')";
           $resultInsert = mysqli_query($conn,$sqlInsert);
           if($resultInsert){
               $id=$conn->insert_id;
               echo  $id;
           }else{
               echo "that bai";
           }
?>