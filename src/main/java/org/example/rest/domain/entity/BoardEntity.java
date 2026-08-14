package org.example.rest.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Table(name = "board")
@Entity
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class BoardEntity extends BaseEntity {
    private String title;
    private String content;

    // 더티 체킹이 일어남
    public void update(BoardEntity boardEntity) {
        this.title = boardEntity.getTitle();
        this.content = boardEntity.getContent();
    }

    // 탈퇴 처리할 때 soft delete나 특정한 상태를 바꿀 때 (show, grade...)
    public void updateTitle(String title) {
        this.title = title;
    }
}
