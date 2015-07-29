package service;

import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.formula.ptg.MemErrPtg;
import org.springframework.stereotype.Service;

import bean.Member;

@Service
public class MuService {
	private static List<Member> list;
	static{
		list=new ArrayList<Member>();
		for(int i=0;i<5;i++){
			list.add(new Member(i, "test"+i, "remark"+i));
		}
	}
	public void show(){
		System.out.println("service show");
	}
	
	public List<Member> getList(){
		return list;
	}
	
	public void add(Member member){
		member.setId(list.size());
		list.add(member);
	}
	
	public void update(Member member){
		Member member2=list.get(member.getId());
		member2.setName(member.getName());
		member2.setRemark(member.getRemark());
	}
	
	public void delete(int id){
		list.remove(id);
	}
}
