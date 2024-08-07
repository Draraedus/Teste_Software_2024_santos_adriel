package com.ufs.testedesoftware.atividade1;

import static org.mockito.Mockito.*;
import static org.powermock.api.mockito.PowerMockito.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest(MySQLDatabaseConnectionFactory.class)
public class MySQLDatabaseConnectionFactoryTest {

	private MySQLDatabaseConnectionFactory reference;

    @Before
    public void setUp() throws Exception {
        reference = new MySQLDatabaseConnectionFactory();
    }

    @Test
    public void testGetConnection() throws SQLException {

        // given
        PowerMockito.mockStatic(DriverManager.class);
        BDDMockito.given(DriverManager.getConnection(anyString(), anyString(), anyString()))
             .willReturn(Mockito.mock(Connection.class));

        // when
        reference.getConnection();

        // then
        PowerMockito.verifyStatic();
        DriverManager.getConnection("jdbc:mysql://myhost:1111/database", "username", "password");
    }
}