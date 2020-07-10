<?php
include "connect.php";


$query = "SELECT DISTINCT user_id, user_name, SUM(total) as totalprice, COUNT(id) as soluongdonhang
FROM account, bill
WHERE bill.id_customer=account.user_id
GROUP BY user_id
ORDER BY total ASC limit 5";

$data=mysqli_query($conn,$query);
$mangtaikhoan= array();
while ($row=mysqli_fetch_assoc($data)) {
    array_push($mangtaikhoan,new TaiKhoan(
        $row['user_id'],
          $row['user_name'],
          
            $row['totalprice'],
            $row['soluongdonhang']              
             )); 

}
echo json_encode($mangtaikhoan);

class TaiKhoan
{
    public function TaiKhoan($user_id, $user_name, $totalprice,$soluongdonhang)
    {
        $this->user_id=$user_id;
        $this->user_name=$user_name;
       
        $this->totalprice=$totalprice;
        $this->soluongdonhang=$soluongdonhang;
      
    }
}


?>

