<?php
include "connect.php";
$page=$_GET['page'];
//$idsp=3;
$id_product=$_POST['id_product'];

$query="SELECT user_id,content
FROM comment
WHERE id_product ='$id_product'";




$data=mysqli_query($conn,$query);
$mangcomment= array();
while ($row=mysqli_fetch_assoc($data)) {
    array_push($mangcomment,new Comments(
        $row['id_comment'],
          $row['id_product'],
           $row['user_id'],
            $row['content']      
             )); 

}
echo json_encode($mangcomment);

class Comments{
    function Comments($id_comment,$id_product,$user_id,$content)
    {
    $this->id_comment=$id_comment;
    $this->id_product=$id_product;
    $this->user_id=$user_id;
    $this->content=$content;
    }
}
?>