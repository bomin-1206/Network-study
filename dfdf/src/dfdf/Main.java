package dfdf;

public class Main
{
    public static void main(String[] args)
    {
        // Body Ŭ������ ��ü ����
        Body body = new Body();
        
        // ��ü�� ���� Body Ŭ������ �Ӽ��� ���� ����ִ´�
        body.arm = "��";
        body.ear = "��";
        body.eye = "��";
        body.leg = "�ٸ�";
        System.out.println("arm = " + body.arm + ", ear = " + body.ear + ", eye = " + body.eye +
                ", leg = " + body.leg);
        
        // ��ü�� ���� Body Ŭ������ �޼��带 ȣ���� �۵��ϵ��� �����Ѵ�
        body.see();
        body.grab();
        body.listen();
        body.walk();
    }
}