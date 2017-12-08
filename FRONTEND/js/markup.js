'use strict';
/*jshint esversion: 6 */

const article = {
	img: 'img/daniel-monteiro-313651.jpg',
	text: 'Testi onnistui',
	title: 'Testi onnistui',
	user: 'img/bekir-donmez-372498.jpg',
	votes: '+ 420'
};

const comment = {
	user: '',
	profilePic: '',
	commentText: '',
	date: ''
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
    <div class="buttons"> <button class="upvote"><img src="icons/upvote.png"></button> <button class="downvote"><img src="icons/downvote.png"></button> <button class="like"><img src="icons/like.png"><button class="comment-btn"><img src="icons/comment.png" alt="comment"></button>
 </div>
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
    <div class="buttons"> <button class="upvote"><img src="icons/upvote.png"></button> <button class="downvote"><img src="icons/downvote.png"></button> <button class="like"><img src="icons/like.png"><button class="comment-btn"><img src="icons/comment.png" alt="comment"></button>
 </div>
  </article>
`;

const markupComment = `
<!-- Comment -->
	<article class="comment">
    <div class="article_top">
      <header>
        <div class="profile_border">
          <div class="cropper"><img src="${comment.profilePic}" class="profile"></div>
        </div>
        <h1 class="username">${comment.user}</h1>
      </header>
    </div>
      <p>${comment.commentText}</p>
	<footer class="comment-footer">
		<h2>${comment.date}</h2>
	</footer>
  </article>
`;


document.querySelector("main").innerHTML += markupTxt;
document.querySelector("main").innerHTML += markupImg;
document.querySelector(".comments-container").innerHTML += markupComment;