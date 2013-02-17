package com.moogu.dcs.test.common;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit38.AbstractTransactionalJUnit38SpringContextTests;
import org.springframework.test.context.transaction.TransactionConfiguration;

@ContextConfiguration(loader = CustomContextLoader.class)
@TransactionConfiguration(defaultRollback = true)
public abstract class AbstractDcsIntegrationTest extends AbstractTransactionalJUnit38SpringContextTests {

    protected AbstractDcsIntegrationTest() {
        super();
    }

}
