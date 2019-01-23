package com.openwallet.core.coins;

import com.openwallet.core.coins.families.BitFamily;

/**
 * @author John L. Jegutanis
 */
public class Medcoin extends BitFamily {
    private Medcoin() {
        id = "medcoin.main";

        addressHeader = 51;
        p2shHeader = 5;
        acceptableAddressCodes = new int[] { addressHeader, p2shHeader };
        spendableCoinbaseDepth = 100;
        dumpedPrivateKeyHeader = 179; //176 for LTC 128/BTC  179 for b3 med

        name = "Mediterraneancoin";
        symbol = "MED";
        uriScheme = "mediterraneancoin";
        bip44Index = 2;
        unitExponent = 8;
        feeValue = value(1000000); // 0.001
        minNonDust = value(10000); // 0.0001 MED mininput
        softDustLimit = value(100000); // 0.001 MED
        softDustPolicy = SoftDustPolicy.BASE_FEE_FOR_EACH_SOFT_DUST_TXO;
        signedMessageHeader = toBytes("Mediterraneancoin Signed Message:\n");
    }

    private static Medcoin instance = new Medcoin();
    public static synchronized CoinType get() {
        return instance;
    }
}
