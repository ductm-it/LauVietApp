<?php
include "connect.php";
$page=$_GET['page'];
$id_customer =$_POST['id_customer'];
$space=5;
$limit=($page-1)*$page;
$query="SELECT id,date_order,total,id_customer
FROM bill
WHERE id_customer = '$id_customer'
LIMIT $limit,$space"; 



$data=mysqli_query($conn,$query);
$mangdonhang= array();
while ($row=mysqli_fetch_assoc($data)) {
    array_push($mangdonhang,new DonHang(
           $row['id'], 
           $row['id_customer'],     
           $row['date_order'],
           $row['total']       
     
             )); 

}
echo json_encode($mangdonhang);

class DonHang{
    function DonHang($id,$id_customer,$date_order,$total)
    {
    $this->id=$id; 
    $this->id_customer=$id_customer; 
    $this->date_order=$date_order;
    $this->total=$total;  
    }
}
?>