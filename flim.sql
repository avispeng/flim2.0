CREATE DATABASE IF NOT EXISTS flim;
USE flim;

CREATE TABLE IF NOT EXISTS users
(
  `userid` int(11) NOT NULL AUTO_INCREMENT,
  `username` char(20) NOT NULL,
  `hashed_pwd` char(64) NOT NULL,
  `salt` char(8) NOT NULL,
  `email` varchar(254) DEFAULT NULL,
  `location` char(30) DEFAULT NULL,
  `nickname` char(40) NOT NULL,
  `gender` int(1) NOT NULL,
  `birthday` date DEFAULT NULL,
  `intro` text DEFAULT NULL,
  PRIMARY KEY (`userid`)
);

CREATE TABLE IF NOT EXISTS reviews (
  `review_id` int(11) NOT NULL AUTO_INCREMENT,
  `movie_id` int(11) NOT NULL,
  `movie_title` varchar(250) NOT NULL,
  `userid` int(11) NOT NULL,
  `username` char(20) NOT NULL,
  `review_title` varchar(130) DEFAULT NULL,
  `review` text NOT NULL,
  `thumb_up` int(11) NOT NULL,
  `time_stamp` datetime NOT NULL,
  `rating` float DEFAULT NULL,
  PRIMARY KEY (`review_id`)
);

CREATE TABLE IF NOT EXISTS movies 
(
  `movie_id` int(11) NOT NULL AUTO_INCREMENT,
  `imdb_id` char(9) NOT NULL,
  `movie_title` varchar(250) NOT NULL,
  `rating` float DEFAULT NULL,
  `directors` json DEFAULT NULL,
  `writers` json DEFAULT NULL,
  `stars` json DEFAULT NULL,
  `aka` json DEFAULT NULL,
  `languages` json DEFAULT NULL,
  `countries` json DEFAULT NULL,
  `release_date` date DEFAULT NULL,
  `genres` json DEFAULT NULL,
  `poster` varchar(512) DEFAULT NULL,
  `summary` text,
  `rating_capita` int(11) DEFAULT NULL,
  `rating_sum` float DEFAULT NULL,
  PRIMARY KEY (`movie_id`)
);

CREATE TABLE IF NOT EXISTS comments
(
  `comment_id` int(11) NOT NULL AUTO_INCREMENT,
  `review_id` int(11) NOT NULL,
  `floor` int(11) NOT NULL,
  `reply_to` int(11) DEFAULT NULL,
  `userid` int(11) NOT NULL,
  `username` char(20) NOT NULL,
  `content` text NOT NULL,
  `thumb_up` int(11) NOT NULL,
  `time_stamp` datetime NOT NULL,
  PRIMARY KEY (`comment_id`)
);
