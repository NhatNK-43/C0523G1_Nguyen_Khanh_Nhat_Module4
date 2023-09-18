package com.example.repository;

import com.example.model.Email;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class EmailRepository implements IEmailRepository{
    private static List<Email> emailList = new ArrayList<>();
    static {
        emailList.add(new Email(1,"Vietnamese",15,true,"NhatNK"));
        emailList.add(new Email(2,"Chinese",100,false,"China"));
        emailList.add(new Email(3,"Japanese",25,true,"Japan"));
        emailList.add(new Email(4,"English",50,true,"England"));
    }

    @Override
    public List<Email> getAll() {
        return emailList;
    }

    @Override
    public Email getEmailById(int id) {
        for (Email email:emailList){
            if(email.getId()==id){
                return email;
            }
        }
        return null;
    }


    @Override
    public void update(int idUpdate, Email email) {
        int index = -1;
        for (int i=0; i<emailList.size();i++){
            if(emailList.get(i).getId()==idUpdate){
                index=i;
            }
        }
        if (index!=-1){
            emailList.set(index,email);
        }
    }
}
