package com.example.user.myapp2.member;

/**
 * Created by USER on 2016-06-11.
 */
public interface MemberService {
    public String signup(MemberBean member);
    public MemberBean login(MemberBean member);
    public MemberBean update(MemberBean member);
    public String delete(MemberBean member);

}
