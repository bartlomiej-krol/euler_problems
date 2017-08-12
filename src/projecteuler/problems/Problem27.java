package projecteuler.problems;

import java.util.List;
import java.util.ArrayList;


/**
 *
 * @author Branimir
 */
public class Problem27 implements ProjectEulerProblem {

    public Problem27() {
        primes.add(2L);
    }

    @Override
    public String description() {
        return "Problem 27: Quadratic primes\n"
                + "Euler discovered the remarkable quadratic formula:\n" +
"\n" +
"n2+n+41\n" +
"\n" +
"It turns out that the formula will produce 40 primes for the consecutive integer values 0≤n≤39\n" +
". However, when n=40,402+40+41=40(40+1)+41 is divisible by 41, and certainly when n=41,412+41+41\n" +
"\n" +
"is clearly divisible by 41.\n" +
"\n" +
"The incredible formula n2−79n+1601\n" +
"was discovered, which produces 80 primes for the consecutive values 0≤n≤79\n" +
"\n" +
". The product of the coefficients, −79 and 1601, is −126479.\n" +
"\n" +
"Considering quadratics of the form:\n" +
"\n" +
"    n2+an+b\n" +
"\n" +
", where |a|<1000 and |b|≤1000\n" +
"\n" +
"where |n|\n" +
"is the modulus/absolute value of n\n" +
"e.g. |11|=11 and |−4|=4\n" +
"\n" +
"Find the product of the coefficients, a\n" +
"and b, for the quadratic expression that produces the maximum number of"
                + " primes for consecutive values of n, starting with n=0.";
    }

    private static final List<Long> primes = new ArrayList();
    @Override
    public String solve() {
        final int N = 1000;
        int productOfCoefficientsAB = 0;
        int bestPrimesNumber = 0;
        //GET ALL PRIMES BELOW N for B coefficient
        List<Integer> primesBelowN = new ArrayList();
        for(int i = 3; i < N; i+=2) {
            if(isPrime(i)) {
                primesBelowN.add(i);
                primesBelowN.add(-i);
            }            
        }
        
        for(int a = -N + 1; a < N; a++) {
            for(Integer b : primesBelowN) {
                int counter = 0;
                for(int i = 0; ; i++) {
                    if(!isPrime(i*i + a * i + b)) break;
                    counter++;                        
                }
                if(counter > bestPrimesNumber) {
                    bestPrimesNumber = counter;
                    productOfCoefficientsAB = a*b;
                }
            }
        }
        
        return String.valueOf(productOfCoefficientsAB);
    }

    private boolean isPrime(long n) {
       n = Math.abs(n);
       if(n < 2) return false;
       if(primes.contains(n)) return true;
       
       long sqrt = (long)Math.sqrt(n);
       int last = primes.size()-1;
       if(n > primes.get(last)) {
           if(sqrt > primes.get(last)) {
               for(long i = primes.get(last) + 2; i <= sqrt; i+=2) {
                   isPrime(i);
               }
           }
           for(Long i : primes) {
               if(i > sqrt) break;
               if(n % i == 0) return false;
           }
       } else return false;
       primes.add(n);
       return true;
    }
}
