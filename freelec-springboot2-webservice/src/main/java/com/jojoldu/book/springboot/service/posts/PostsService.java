package com.jojoldu.book.springboot.service.posts;

import com.jojoldu.book.springboot.domain.posts.PostsRepository;
import com.jojoldu.book.springboot.web.dto.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor // 롬복 어노테이션. final이 선언된 모든 필드를 인자값으로 하는 생성자 생성
                        // 생성자를 직접 안 쓴 이유: 해당 클래스의 의존성 관계가 변경될 때마다 생성자 코드를 계속 수정해야 하는 번거로움 해결 위해
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }
}
