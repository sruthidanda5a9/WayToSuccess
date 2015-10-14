var slideImages = new Array();
slideImages[0] = new Image(); 
slideImages[0].src = "Images/home1.jpg";
slideImages[1] = new Image();
slideImages[1].src = "Images/Home2.jpg";
slideImages[2] = new Image();
slideImages[2].src = "Images/Home3.jpg";
slideImages[3] = new Image();
slideImages[3].src = "Images/Home4.jpg";
slideImages[4] = new Image();
slideImages[4].src = "Images/Home5.jpg";
var slide=0
function SlideImages(){
	if (!document.images)
		return
		document.getElementById('slideImages').src = slideImages[slide].src;
	if (slide<4)
		slide++;
	else
		slide=0;
	setTimeout("SlideImages()",2500);
}










