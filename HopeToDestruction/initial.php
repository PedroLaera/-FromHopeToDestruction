<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Titulo da Página</title>
</head>
<body>
    <main>
        <div class="console-box">
            <p><?= $arrayAssociativo->mensagem ?></p>
        </div>
        <div class="form-group">
            <form>
                <input type="text" name="comando" />
                <input type="text" name="save" value="<?= $arrayAssociativo->idSave ?>" readonly />
                <input type="submit" />
            </form>
        </div>
    </main>
</body>

</html>