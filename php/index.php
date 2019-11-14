<!DOCTYPE html>
<html>
<head>
   <meta charset="utf-8"> 
   <title>豆瓣电影TOP250</title>
   <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<?php
    $con=mysqli_connect("localhost","filmdata","filmdatafilmdatafilmdatafilmdata","filmdata");
    mysqli_query($con,"set names 'utf8'");
?>
<body background="back.png">
<div class="container">
	<div class="row clearfix">
	<div class="col-md-12 column">
		<br><br>
        <table class="table table-hover table-bordered">
		<thead>
			<tr>
				<th>
					排名
				</th>
				<th>
					电影名称
				</th>
				<th>
					类型
				</th>
                <th>
					评分
				</th>
                <th>
					简评
				</th>
                <th>
					详情页面
				</th>
			</tr>
		</thead>
        <tbody>
        <?php
        $result=mysqli_query($con,"select * from listdata");
        while($row=mysqli_fetch_assoc($result)){
            echo '<tr class="default">';
			echo "<td>".$row["rank_num"]."</td>";
			echo "<td>".$row["title"]."</td>";
            echo "<td>".$row["type"]."</td>";
            echo "<td>".$row["score"]."</td>";
            echo "<td>".$row["short_comment"]."</td>";
            echo "<td>".'<a href="detail.php?url='.$row["detail_page_url"].'&rank='.$row["rank_num"].'" target="_blank">点击进入</a>'."</td>";
			echo "</tr>";
        }
        ?>
        </tbody>
	</table>
	</div>
	</div>
    <br><br><br><br><br><br>
    <div class="row clearfix">
	    <div class="col-md-4 column">
		</div>
        <div class="col-md-6 column">
            <?php
                $info=mysqli_query($con,"select * from listdata");
                while($row=mysqli_fetch_assoc($info)){
                    echo '<img src="./list_img/'.$row["rank_num"].'.jpg">'."<br>";
                    echo "<br><br>";
                    echo "排名 : ".$row["rank_num"]."<br>";
                    echo "中文名 : ".$row["ch_name"]."<br>";
                    echo "外文名 : ".$row["eng_name"]."<br>";
                    echo "又名 : ".$row["other_name"]."<br>";
                    echo "标题 : ".$row["title"]."<br>";
                    echo "是否可播放 : ".$row["playable"]."<br>";
                    echo "基本信息 : ".$row["base_info"]."<br>";
                    echo "类型 : ".$row["type"]."<br>";
                    echo "评分 : ".$row["score"]."<br>";
                    echo "评论次数 : ".$row["comment_num"]."<br>";
                    echo "简评 : ".$row["short_comment"]."<br>";
                    echo "图片链接 : ".$row["img_url"]."<br>";
                    echo "详情页链接 : ".$row["detail_page_url"]."<br>";
                    echo "<br><br><br><br><br><br><br><br>";
                }
            ?>
		</div>
        <div class="col-md-2 column">
		</div>
	</div>
    <br><br><br><br><br><br><br><br>
</div>
</body>