<?php
include "connect.php";
$page=$_GET['page'];

$space=5;
$limit=($page-1)*$page;
$query="SELECT id,id_customer,date_order,total,note,status
FROM bill
LIMIT $limit,$space"; 



$data=mysqli_query($conn,$query);
$mangdonhang= array();
while ($row=mysqli_fetch_assoc($data)) {
    array_push($mangdonhang,new DonHang(
        $row['id'],
          $row['id_customer'],
           $row['date_order'],
           $row['total'],
           $row['note'],
           $row['status']
     
             )); 

}
echo json_encode($mangdonhang);

class DonHang{
    function DonHang($id,$id_customer,$date_order,$total,$note,$status)
    {
    $this->id=$id;
    $this->id_customer=$id_customer;
    $this->date_order=$date_order;
    $this->total=$total;
    $this->note=$note;
    $this->status=$status;
  
    }
}
?>