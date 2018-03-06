package com.chinasoft.obs.data.entity;

import javax.persistence.*;

/**
 * Created by VerRan.Liu on 2017/12/7.
 */
@Entity
//@Table(name="document_info")
public class DocumentInfo implements java.io.Serializable{
    /**文档id*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name="id")
    private Long id;

//    @Column(name="docName")
    private String docName;

    @Enumerated(EnumType.STRING) @Column(length=3,nullable=false) //枚举类型，且将值存入数据库
    private DOCTYPE docType=DOCTYPE.F;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDocName() {
        return docName;
    }

    public void setDocName(String docName) {
        this.docName = docName;
    }
}
