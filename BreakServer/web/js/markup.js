'use strict';
/*jshint esversion: 6 */

let article = {
	ID: "",
	user: "",
	title: "",
	article: "",
	hasMedia: ""
};
// let comment;

const markupFeed = (jsonServlet) => {

	let json;

	fetch(jsonServlet)
		.then((response) => {
			return response.json();
		})
		.then((result) => {

			json = result;
			console.log(json.length);

			for (var i = 0; i < json.length; i++) {

				article.ID = json[i].ID;
				article.user = json[i].user;
				article.title = json[i].title;
				article.article = json[i].article;
				article.hasMedia = json[i].hasMedia;

				console.log(article);
				console.log(article.hasMedia);

				let markupImg = `
  <!-- MEDIA ARTICLE -->
  <article id="postId-${article.ID}">
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

				let markupTxt = `
<!-- TEXT ARTICLE -->
<article id="postId-${article.ID}">
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
				// THIS MUST BE WITH == NOT WITH === !!!!!!!!
				if (article.hasMedia == 1) {
					console.log("CREATING IMAGE TING");
					document.querySelector("main").innerHTML += markupImg;
				} else {
					console.log("CREATING TEXT TING");
					document.querySelector("main").innerHTML += markupTxt;
				}
			}
		});
};


/*
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
*/

window.onload = markupFeed('test.json');
// document.querySelector(".comments-container").innerHTML += markupComment;
