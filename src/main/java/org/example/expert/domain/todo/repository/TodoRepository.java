package org.example.expert.domain.todo.repository;

import org.example.expert.domain.todo.entity.Todo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface TodoRepository extends JpaRepository<Todo, Long> {


    //목록조회
    // todo entity 불러오기      // todo와 관련있는 유저정보 불러오고 수정시간 내림차순으로 정렬하기
    @Query("SELECT t FROM Todo t LEFT JOIN FETCH t.user u ORDER BY t.modifiedAt DESC")
    // page 형태로
    Page<Todo> findAllByOrderByModifiedAtDesc(Pageable pageable);


    // 상세조회
    // todo entity 불러오기      // todo와 관련있는 유저정보 불러오는데 특정id에 관한것만 불러오기
    @Query("SELECT t FROM Todo t " +
            "LEFT JOIN FETCH t.user " +
            "WHERE t.id = :todoId")
    Optional<Todo> findByIdWithUser(@Param("todoId") Long todoId);

    int countById(Long todoId);
}
