'use strict';
/*jshint esversion: 6 */

let article = {
    ID: "",
    user: "",
    profilePic: "",
    title: "",
    article: "",
    hasMedia: ""
};

const markupFeed = (jsonServlet) => {

    let json;

    fetch(jsonServlet)
        .then((response) => {
            return response.json();
        })
        .then((result) => {

            json = result;
            console.log("json length: " + json.length);

            for (var i = 0; i < json.length; i++) {

                /*
                article.ID = json[i].ID;
                article.user = json[i].user;
                article.title = json[i].title;
                article.article = json[i].article;
                article.hasMedia = json[i].hasMedia;
                */

                article.ID = json[i][0];
                article.user = json[i][1];
                article.profilePic = json[i][2];
                article.title = json[i][3];
                article.article = json[i][4];
                article.hasMedia = json[i][5];

                console.log(article);
                console.log(article.hasMedia);

                let markupImg = `
  <!-- MEDIA ARTICLE -->
  <article id="postId-${article.ID}">
    <div class="article_top">
      <header>
		<div class="profile_border">
			<div class="cropper">
				<img src="${article.profilePic}" class="profile">
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


window.onload = markupFeed('http://10.114.34.142:8080/BreakServer/webresources/service/getMedia?');