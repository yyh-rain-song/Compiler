int f(int n) {
    int i;
    int res = 0;
    for (i = 0; i < n; i = i + 1) {
        res = res + i ^ (n & (i - 1));
        res = res % 10000;
    }
    return res;
}

int main()
{
    int ans = f(2);
    println(toString(ans));
//    int i;
//    int j;
//    int k;
//    int ans = 0;
//    for (i = 0; i < 90000000; i++) {
//        for (j = 0; j < 10; j++){
//            if (i >= 89999999) {
//                if (j >= 9){
//                    ans = ans + f(i * 8);
//                }
//            }
//        }
//    }
//    println(toString(ans));

    return 0;
}

/*!! metadata:
=== comment ===
侯博涵
=== is_public ===
True
=== assert ===
output
=== timeout ===
12.0
=== input ===

=== phase ===
optim pretest
=== output ===
3132
=== exitcode ===
0

!!*/
