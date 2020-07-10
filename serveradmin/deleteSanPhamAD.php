


<?php
include "connect.php";
$id = $_POST['id'];
$id_product = $_POST['id_product'];
$Sql_Query = "DELETE FROM images WHERE id_product = '$id_product'
              DELETE FROM product WHERE id = '$id'";

if(mysqli_query($conn,$Sql_Query))
{
echo "xóa thành công";
}
else
{
echo "xóa  không thành công";
}


?>




