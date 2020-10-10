package com.janlei.abs.impl;

import com.janlei.abs.DaoAbs;
import org.springframework.stereotype.Repository;

/**
 * @author admin
 */
@Repository
public class OracleDaoImpl extends DaoAbs {
    @Override
    public void say() {
        System.out.println("Oracle");
    }
}
