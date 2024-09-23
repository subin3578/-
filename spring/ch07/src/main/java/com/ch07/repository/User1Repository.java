package com.ch07.repository;


import com.ch07.entity.User1;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.io.FileFilter;
import java.util.List;

// JpaRepository<T,ID> : 사용하는 엔티티 타입과 해당 엔티티 @ID 컬럼 속성 타입 선언
@Repository
public interface User1Repository extends JpaRepository<User1,String> {
    // DAO 역할

    // 사용자 정의 쿼리 메서드

    public User1 findUser1ByUid(String uid);            // select * from user1 where uid = ?

    public List<User1> findUser1ByName(String name);    // select * from user1 where name = ?

    public List<User1> findUser1ByNameNot(String name); // select * from user1 where name != ?

    public User1 findUser1ByUidAndName(String uid, String name);

    public List<User1> findUser1ByUidOrName(String uid, String name);

    public List<User1> findUser1ByAgeGreaterThan(int age);

    public List<User1> findUser1ByAgeGreaterThanEqual(int age);

    public List<User1> findUser1ByAgeLessThan(int age);

    public List<User1> findUser1ByAgeLessThanEqual(int age);

    public List<User1> findUser1ByAgeBetween(int low, int high);

    public List<User1> findUser1ByNameLike(String name);

    public List<User1> findUser1ByNameContains(String name);

    public List<User1> findUser1ByNameStartsWith(String name);

    public List<User1> findUser1ByNameEndsWith(String name);

/*  OrderBY 부분 때문에 오류 발생 왜 ?
    public List<User1> findUser1ByOrderByName();

    public List<User1> findUser1ByOrderByAgeAsc();

    public List<User1> findUser1ByOrderByAgeDesc();

    public List<User1> findUser1ByOrderByAgeGreaterThanOrderByAgeAsc(int age);
*/
    public int countUser1ByUid(String uid);

    public int countUser1ByName(String name);

    // JPQL : JPA Native SQL => 이게 발전해서 => queryDSL
    // select * from 'User1' (Entity명) as '별칭' where 조건
    @Query("select u1 from User1 as u1 where u1.age < 30")
    public List<User1> selectUser1UnderAge30();

    @Query("select u1 from User1 as u1 where u1.name = ?1")
    public List<User1> selectUser1WhereName(@Param("name") String name);

}