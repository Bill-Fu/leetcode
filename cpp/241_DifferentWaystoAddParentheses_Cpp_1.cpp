#define PLUS -1
#define MINUS -2
#define MULTIPLY -3
class Solution {
public:
    vector<int> diffWaysToComputePack(vector<int> in){
        vector<int> result,tmp1,tmp2,t;
        int i,j,k;
        
        if(in.size()==1)
        {
            result.push_back(in[0]);
            return result;
        }
        else
        {
            for(i=0;i<(in.size()-1)/2;++i)
            {
                t.assign(in.begin(),in.begin()+2*i+1);
                tmp1=diffWaysToComputePack(t);
                t.assign(in.begin()+2*i+2,in.end());
                tmp2=diffWaysToComputePack(t);
                switch(in[2*i+1])
                {
                    case PLUS:
                    {
                        for(j=0;j<tmp1.size();++j)
                        {
                            for(k=0;k<tmp2.size();++k)
                            {
                                result.push_back(tmp1[j]+tmp2[k]);
                            }
                        }
                        break;
                    }
                    case MINUS:
                    {
                        for(j=0;j<tmp1.size();++j)
                        {
                            for(k=0;k<tmp2.size();++k)
                            {
                                result.push_back(tmp1[j]-tmp2[k]);
                            }
                        }
                        break;
                    }
                    case MULTIPLY:
                    {
                        for(j=0;j<tmp1.size();++j)
                        {
                            for(k=0;k<tmp2.size();++k)
                            {
                                result.push_back(tmp1[j]*tmp2[k]);
                            }
                        }
                        break;
                    }
                }
            }
            return result;
        }
    }
    
    vector<int> diffWaysToCompute(string input) {
        vector<int> result,tmp1,tmp2,in;
        int i,j,k,num;
        bool sig=false;
        
        for(i=0;i<input.length();++i)
        {
            switch(input[i])
            {
                case '+':
                {
                    in.push_back(num);
                    in.push_back(PLUS);
                    sig=false;
                    break;
                }
                case '-':
                {
                    in.push_back(num);
                    in.push_back(MINUS);
                    sig=false;
                    break;
                }
                case '*':
                {
                    in.push_back(num);
                    in.push_back(MULTIPLY);
                    sig=false;
                    break;
                }
                default:
                {
                    if(sig==false)
                    {
                        num=input[i]-'0';
                        sig=true;
                    }
                    else
                    {
                        num=num*10+input[i]-'0';
                        sig=true;
                    }
                }
            }
        }
        in.push_back(num);
        
        return diffWaysToComputePack(in);
    }
};
