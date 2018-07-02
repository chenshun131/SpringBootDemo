package com.example.demo.domain;

import lombok.Data;

import javax.persistence.*;

/**
 * User: chenshun131 <p />
 * Time: 18/6/19 23:34  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
@Data
@Table(name = "worker")
public class Worker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "worker_id")
    private String workerId;

    private String name;

    @Column(name = "org_id")
    private Integer orgId;

    private String status;

    @Column(name = "role_id")
    private Integer roleId;

}
