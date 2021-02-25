package com.ssafy.SOL_0223.News;

import java.util.List;

public interface INewsDAO {
	List<News> getNewsList(String url);
	News search(int index);
}