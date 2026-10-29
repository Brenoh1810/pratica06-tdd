# Prática 06 – TDD: Validação de senha

Função `ValidadorSenha.validar(String senha)` desenvolvida com TDD (ciclos RED, GREEN e REFACTOR registrados nos commits).

Retorna um `ResultadoValidacao` com `isValida()` e `getErros()`.

## Regras

| Regra | Mensagem de erro |
|---|---|
| Pelo menos 8 caracteres | A senha deve ter pelo menos 8 caracteres |
| Pelo menos 2 dígitos | A senha deve conter pelo menos 2 dígitos |
| Pelo menos uma letra maiúscula | A senha deve conter pelo menos uma letra maiuscula |
| Pelo menos um caractere especial | A senha deve conter pelo menos um caractere especial |

Quando a senha quebra mais de uma regra, todas as mensagens são retornadas, na ordem acima (ex.: `mypass` retorna as 4).

Caractere especial é qualquer caractere que não seja letra nem dígito. Senha nula é tratada como vazia.

## Testes

Projeto Maven em `tdd_senha`, testes em JUnit 5 (`ValidadorSenhaTest`).
