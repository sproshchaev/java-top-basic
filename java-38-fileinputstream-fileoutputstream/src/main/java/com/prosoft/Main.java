package com.prosoft;

/**
 * java-38-fileinputstream-fileoutputstream
 */
public class Main {
    public static void main(String[] args) {

        /**
         * (Пример 1) Скопировать побайтово файл.
         * Примечание: Данные во входной поток попадают из файла на диске, считаем что размер этого файла позволяет
         * прочитать его сразу.
         * Выполняется чтение и запись файл побайтово, поэтому таким способом можем копировать не только текстовые файлы,
         * но и бинарные (и графические) файлы.
         * Файл test.txt копируется в outputFile1.tmp
         */
        FileAllCopyTryCatchFinally fileAllCopyTryCatchFinally = new FileAllCopyTryCatchFinally();
        fileAllCopyTryCatchFinally.makeCopy();

        /**
         * Тот-же пример 1, но с try-with-resources
         * Файл test.txt копируется в outputFile2.tmp
         */
        FileAllCopyTryWithResources fileAllCopyTryWithResources = new FileAllCopyTryWithResources();
        fileAllCopyTryWithResources.makeCopy();

        /**
         * (Пример 2) Если же мы не можем полагать, что размер данных во входном потоке приемлем, чтобы прочитать его за один
         * раз, то необходимо читать данные в цикле, блоками, помещая данные в массив, а затем из массива в файл.
         * Файл test.txt копируется в outputFile3.tmp
         */
        FileBlockCopyTryWithResources fileBlockCopyTryWithResources = new FileBlockCopyTryWithResources();
        fileBlockCopyTryWithResources.makeCopy();

        /**
         * (Пример 3) Выполнить чтение побайтово (без использования массива), что медленнее, но иногда бывает необходимо обрабатывать
         * каждый прочитанный байт
         * Файл test.txt копируется в outputFile4.tmp
         */
        FileByteCopyTryWithResources fileByteCopyTryWithResources = new FileByteCopyTryWithResources();
        fileByteCopyTryWithResources.makeCopy();

    }
}
