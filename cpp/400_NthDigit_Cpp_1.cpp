class Solution {
public:
    int findNthDigit(int n) {
        int num=0,base=0;
        int i;
        while(n-9*(base+1)*pow(10,base)>0){
            n-=9*(base+1)*pow(10,base);
            num+=9*pow(10,base);
            base++;
        }
        num+=(n-1)/(1+base);
        num++;
        n=((n-1)%(1+base))+1;
        for(i=0;i<(base+1-n);++i)
        {
            num/=10;
        }
        return num%10;
    }
};
