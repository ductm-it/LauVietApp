<?php
include "connect.php";
$page=$_GET['page'];
$idsp=$_POST['id_bill'];
//$idsp=54;
$space=5;
$limit=($page-1)*$page;

$query="SELECT bill_detail.id,id_bill,id_product,quantity,bill_detail.price,name
FROM bill_detail,product 
WHERE bill_detail.id_product=product.id and id_bill= $idsp
LIMIT $limit,$space"; 



$data=mysqli_query($conn,$query);
$mangchitietdonhang= array();
while ($row=mysqli_fetch_assoc($data)) {
    array_push($mangchitietdonhang,new ChiTietDonHang(
        $row['id'],
          $row['id_bill'],
           $row['id_product'],
            $row['quantity'],
            $row['price'],
            $row['name']
             )); 

}
echo json_encode($mangchitietdonhang);

class ChiTietDonHang{
    function ChiTietDonHang($id,$id_bill,$id_product,$quantity,$price,$name)
    {
    $this->id=$id;
    $this->id_bill=$id_bill;
    $this->id_product=$id_product;
    $this->quantity=$quantity;
    $this->price=$price;
    $this->name=$name;
    }
}
?>