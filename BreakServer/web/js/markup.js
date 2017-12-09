'use strict';
/*jshint esversion: 6 */

let article;
let comment;
/*
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
    <div class="article_media"> <img src="${article.article}" class="article">
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
      <p class="article">${article.article}</p>
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
*/



// GET
const getJson = (responseServlet) => {
	fetch(responseServlet)
		.then((response) => {
			return response.json();
		})
		.then((result) => {
			console.log(result);
		});
};

// JSON.parse(getJson(jsonSerlvet));

const markupFeed = (jsonSerlvet) => {
	
	const json = getJson(jsonSerlvet);
	
	for (var i = 0; i < json.length; i++) {

		article = {
			user: 'json[i].user',
			title: 'json[i].title',
			article: 'json[i].article',
			hasMedia: 'json[i].hasMedia'
		};

		if (article.hasMedia === 1) {
			document.querySelector("main").innerHTML += markupImg;
		} else {
			document.querySelector("main").innerHTML += markupTxt;
		}
	}
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
      <h2>VOTES</h2>
    </div>
    <div class="article_media"> <img src="${article.article}" class="article">
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
      <h2>VOTES</h2>
    </div>
    <div class="article_media">
      <p class="article">${article.article}</p>
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
		<h2>VOTES</h2>
	</footer>
  </article>
`;

document.onload.markupFeed('http://10.114.34.142:8080/BreakServer/webresources/service/getAllMedia?');
document.querySelector(".comments-container").innerHTML += markupComment;
