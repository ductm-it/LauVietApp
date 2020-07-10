<?php
include "connect.php";
$link =$_POST['link'];
$id_product =$_POST['id_product'];
$query="INSERT INTO images(id,link,id_product)
         VALUES(null,'$link',$id_product)";
if (mysqli_query($conn,$query)) {
  
    echo  "1";
}else{
    echo "0";
}
?>


