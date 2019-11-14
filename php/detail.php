<!DOCTYPE html>
<html>
<head>
   <meta charset="utf-8"> 
   <title>电影详情</title>
   <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<?php
    $con=mysqli_connect("localhost","filmdata","filmdatafilmdatafilmdatafilmdata","filmdata");
    mysqli_query($con,"set names 'utf8'");
    $rank_num=$_GET["rank"];
    $get_url=$_GET["url"];
?>
<body background="back.png">
<div class="container">
    <br><br><br><br><br><br>
    <div class="row clearfix">
	    <div class="col-md-4 column">
		</div>
        <div class="col-md-6 column">
            <?php
                $info=mysqli_query($con,"select * from detaildata where `detail_link`='{$get_url}'");
                $result=mysqli_fetch_array($info);
                echo '<img src="./list_img/'.$rank_num.'.jpg">'."<br>";
                echo "<br><br>";
                echo "标题 : ".$result["title"]."<br>";
                echo "发布时间 : ".$result["publish_date"]."<br>";
                echo "导演 : ".$result["director"]."<br>";
                echo "编剧 : ".$result["author"]."<br>";
                echo "主演 : ".$result["actor"]."<br>";
                echo "类型 : ".$result["type"]."<br>";
                echo "制片国家/地区 : ".$result["make_location"]."<br>";
                echo "语言 : ".$result["language"]."<br>";
                echo "上映日期 : ".$result["show_date"]."<br>";
                echo "片长 : ".$result["length"]."<br>";
                echo "又名 : ".$result["other_name"]."<br>";
                echo "IMDb链接 : ".$result["IMDb_link"]."<br>";
                echo "豆瓣评分 : ".$result["ratingValue"]."<br>";
                echo "评价次数 : ".$result["comment_num"]."<br>";
                echo "5星评价所占比例 : ".$result["star5_rating_per"]."<br>";
                echo "4星评价所占比例 : ".$result["star4_rating_per"]."<br>";
                echo "3星评价所占比例 : ".$result["star3_rating_per"]."<br>";
                echo "2星评价所占比例 : ".$result["star2_rating_per"]."<br>";
                echo "1星评价所占比例 : ".$result["star1_rating_per"]."<br>";
                echo "剧情简介 : ".$result["description"]."<br>";
                echo "图片链接 : ".$result["img_url"]."<br>";
                echo "网址 : ".$result["detail_link"]."<br>";
                echo "<br><br><br><br><br><br><br><br>";
            ?>
		</div>
        <div class="col-md-2 column">
		</div>
	</div>
    <br><br><br><br><br><br><br><br>
</div>
</body>