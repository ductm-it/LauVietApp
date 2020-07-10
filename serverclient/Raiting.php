<?php
    require_once('connect.php');
    mysqli_set_charset($conn,'utf8');
		$id_ratings = $_POST['id_ratings'];
		$id_product = $_POST['id_product'];
        $user_id = $_POST['user_id'];
        $star = $_POST['star'];
        $sqlInsert = "INSERT INTO ratings (id_ratings,id_product,user_id,star) VALUES (null,'$id_product','$user_id','$star')";
        $resultInsert = mysqli_query($conn,$sqlInsert);
        if($resultInsert){
            $id=$conn->insert_id;
            echo  $id;
        }else{
            echo "that bai";
        }
?>