'use strict';
/*jshint esversion: 6 */

const article = {
	img: 'img/daniel-monteiro-313651.jpg',
	text: 'Testi onnistui',
	title: 'Testi onnistui',
	user: 'img/bekir-donmez-372498.jpg',
	votes: '+ 420'
};

const markupImg = `
  <!-- MEDIA ARTICLE -->
  <article>
    <div class="article_top">
      <header>
		<div class="profile_border">
			<div class="cropper">
				<img src="${article.user}" class="profile">
			</div>
		</div>        
		<h1>${article.title}</h1>
      </header>
      <h2>${article.votes}</h2>
    </div>
    <div class="article_media"> <img src="${article.img}" class="article">
    </div>
    <div class="buttons"> <img src="icons/upvote.png"> <img src="icons/downvote.png"> <img src="icons/like.png"> <img src="icons/comment.png"> </div>
  </article>
`;

const markupTxt = `
<!-- TEXT ARTICLE -->
 <article>
    <div class="article_top">
      <header>
		<div class="profile_border">
			<div class="cropper">
				<img src="${article.user}" class="profile">
			</div>
		</div>
		<h1>${article.title}</h1>
      </header>
      <h2>${article.votes}</h2>
    </div>
    <div class="article_media">
      <p class="article">${article.text}</p>
    </div>
    <div class="buttons"> <img src="icons/upvote.png"> <img src="icons/downvote.png"> <img src="icons/like.png"> <img src="icons/comment.png"> </div>
  </article>
`;


document.querySelector("main").innerHTML += markupTxt;
document.querySelector("main").innerHTML += markupImg;