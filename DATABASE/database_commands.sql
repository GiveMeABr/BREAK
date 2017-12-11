CREATE TABLE Users(
    UserID INT UNIQUE AUTO_INCREMENT PRIMARY KEY,
    Username VARCHAR(20),
    Email VARCHAR(100),
    ModStatus BOOLEAN DEFAULT NULL,
    UserSecretCode VARCHAR(255),
    ProfilePic VARCHAR(255)
);

CREATE TABLE Article(
    ArticleID INT UNIQUE AUTO_INCREMENT PRIMARY KEY,
    UploadDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    Sender INT,
    FOREIGN KEY (Sender) REFERENCES Users(UserID),
    Title VARCHAR(60),
    Article VARCHAR(255),
    NSFW BOOLEAN DEFAULT NULL,
    hasMedia BOOLEAN
);

CREATE TABLE Tags(
    TagID INT UNIQUE AUTO_INCREMENT PRIMARY KEY,
    Tag VARCHAR(50)
);

CREATE TABLE Comments(
    Comment VARCHAR(160),
    Commenter INT,
    Article INT,
    FOREIGN KEY (Commenter) REFERENCES Users(UserID),
    FOREIGN KEY (Article) REFERENCES Article(ArticleID),
    CommentDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CommentID INT UNIQUE AUTO_INCREMENT PRIMARY KEY
);

CREATE TABLE Votes(
    Voter INT,
    Article INT,
    VoteType BOOLEAN,
    FOREIGN KEY (Voter) REFERENCES Users(UserID),
    FOREIGN KEY (Article) REFERENCES Article(ArticleID),
    PRIMARY KEY (Voter, Article)
);

CREATE TABLE TagMap(
    Article INT,
    Tag INT,
    FOREIGN KEY (Article) REFERENCES Article(ArticleID),
    FOREIGN KEY (Tag) REFERENCES Tags(TagID),
);

CREATE TABLE Favorites(
    User INT,
    Article INT,
    FOREIGN KEY (User) REFERENCES Users(UserID),
    FOREIGN KEY (Article) REFERENCES Article(ArticleID),
    PRIMARY KEY (User, Article)
);

CREATE TABLE Follows(
    User INT,
    Followed INT,
    FOREIGN KEY (User) REFERENCES Users(UserID),
    FOREIGN KEY (User) REFERENCES Users(UserID),
    PRIMARY KEY (User, Followed)
);
