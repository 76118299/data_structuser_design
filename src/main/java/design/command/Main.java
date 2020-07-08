package design.command;

public class Main {
    /**
     * 接收者
     */
    public static class Receiver{
        public void action(){
            System.out.printf("执行命令");
        }
    }
    public interface Command{
        void execute();
        void undo();
    }
    /**
     * 具体的命令角色 并聚合接收者
     */
    public static class ConcreateCommand implements Command{
        private Receiver receiver; // 聚合接收者
        String undoCommand;//记录撤销的命令

        public ConcreateCommand(Receiver receiver) {
            this.receiver = receiver;
        }

        public void execute() {
            receiver.action();
        }

        public void undo() {
            //TODO 可以把命令对象存入集合中，进行循环执行undo方法进行命令的撤销
        }
    }
    /**
     * 调用者 聚合命令
     */
    public static class Invoker{
        /**
         * 持有命令
         */
        private Command command;
        public Invoker(Command command) {
            this.command = command;
        }
        /**
         * 执行命令
         */
        public void action(){
            command.execute();
        }
        /**
         * 撤销命令
         */
        public void undo(){
            command.undo();
        }
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        //创建接收者
        Receiver receiver = new Receiver();
        //创建命令
        Command command = new ConcreateCommand(receiver);
        //创建调用者
        Invoker i = new Invoker(command);
        i.action();
    }
}
