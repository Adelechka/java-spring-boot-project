package ru.itis.reddit.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.reddit.model.Post;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostView {
    private Post post;
    private Integer isLiked;
}
