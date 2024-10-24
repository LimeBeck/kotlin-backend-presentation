#!/usr/bin/env -S jbang revealkt@limebeck.dev run

import dev.limebeck.revealkt.core.RevealKt
import dev.limebeck.revealkt.utils.ID
import dev.limebeck.revealkt.utils.UuidGenerator
import qrcode.color.Colors

title = "Kotlin в тылу"

configuration {
    touch = true
    slideNumber = RevealKt.Configuration.SlideNumber.Enable
    controlsLayout = RevealKt.Configuration.ControlsLayout.EDGES
    theme = RevealKt.Configuration.Theme.Predefined.BLACK
    additionalCssStyle = loadAsset("additional.css").decodeToString()
    controls = false
    controlsTutorial = false
    fragmentInURL = true
    hash = true
}

val `$` = "$"

slides {
    verticalSlide {
        slide {
            +title { "Kotlin в тылу" }
            +smallTitle { "Используем Kotlin для серверной разработки" }
        }
        slide {
            +smallTitle { "Обо мне" }
            +row {
                column {
                    +img(src = "me.jpg") {
                        height = 400
                    }
                }
                column {
                    +unorderedListOf(
                        listOf(
                            "Техлид JVM Backend в Банке Центр-инвест",
                            "Фанат Kotlin",
                            "Пишу на Kotlin 6 лет",
                            "Вкатился с Python",
                        ),
                        fragmented = false,
                    )
                }
            }
        }
    }

    verticalSlide {
        val id = UuidGenerator.generateId()
        slide {
            +smallTitle(id) { "Kotlin - только для Android" }
        }
        slide {
            +smallTitle(id) { "Kotlin - только для Android?" }
        }

        slide {
            +smallTitle(id) { "Kotlin - только для Android?" }
            +smallTitle { "Конечно нет" }
        }

        slide {
            +smallTitle { "The State of" }
            +smallTitle { "Developer Ecosystem" }
            +img("state-of-kotlin.png") {
                stretch = true
            }
        }

        slide {
            +smallTitle { "Целевые платформы Kotlin" }
            +unorderedListOf(
                "Kotlin JVM",
                "Kotlin Js (Node JS, Browser)",
                "Kotlin Native (Linux, Windows, macOS, iOS, etc)",
                "Kotlin Wasm",
                "Kotlin Script",
                fragmented = false,
            )
        }

        slide {
            +smallTitle { "На Kotlin можно написать" }
            +unorderedListOf(
                "Backend",
                "Android",
                "iOS",
                "Web Frontend",
                "Desktop",
                "Общая часть",
                "Скриптинг",
                "Презентацию",
            )
        }
    }

    verticalSlide {
        slide {
            +title { "Почему не взять Java?" }
        }
        slide {
            +smallTitle { "Null Safety" }
            +regular { "Java" }
            +javaCode {
                """
                String clientName;
                if (client != null && client.person != null) {
                    clientName = client.person.surname + " " + client.person.name[0] + ".";
                } else {
                    clientName = "unknown";
                }
                """.trimIndent()
            }

            +regular { "Kotlin" }
            +kotlinCode {
                """
                val clientName = client?.person?.let { "$`$`{it.surname} $`$`{it.name.first()}." } ?: "unknown"
                """.trimIndent()
            }
        }
        slide {
            +smallTitle { "Иммутабельность" }
            +smallTitle { "по умолчанию" }
        }
        slide {
            +smallTitle { "Иммутабельность" }
            +smallTitle { "по умолчанию" }

            +smallTitle { "В переменных" }
            +kotlinCode {
                """
                val immutable = "value"
                
                var mutable = "value"
                mutable = "newValue"
                
                var notChanged = "notChangedValue" //Предупреждение компилятора о неизменности данных
                """.trimIndent()
            }
        }
        slide {
            +smallTitle { "Иммутабельность" }
            +smallTitle { "по умолчанию" }

            +smallTitle { "В структурах данных" }
            +kotlinCode {
                """
                val immutableList = listOf("value1", "value2")
                immutableList += "newValue" //Не скопилируется - нет метода add
                
                val mutableList = mutableListOf("value1", "value2")
                mutableList += "newValue"
                """.trimIndent()
            }
        }
        slide {
            +smallTitle { "Иммутабельность" }
            +smallTitle { "по умолчанию" }

            +smallTitle { "В структурах данных" }
            +kotlinCode {
                """
                val immutableMap = mapOf("key" to "value")
                immutableMap["key2"] = "newValue" //Не скопилируется - нет метода put
                
                val mutableMap = mutableMapOf("key" to "value")
                mutableMap["key2"] = "newValue"
                """.trimIndent()
            }
        }
        slide {
            +smallTitle { "Кроме того" }
        }
        slide {
            +smallTitle { "Кроме того" }
            +unorderedListOf(
                "Лаконичность",
                "Функциональный подход",
                "Корутины",
                "Кроссплатформа",
            )
        }
    }

    verticalSlide {
        slide {
            +smallTitle { "Kotlin Backend фреймворки" }
        }
        slide {
            +smallTitle { "Что такое фреймворк?" }
        }
        slide {
            +smallTitle { "Что такое фреймворк?" }
            +regular { "инструмент, который помогает быстрее и проще создавать приложения, следуя уже проверенной структуре и логике" }
        }
//        slide {
//            +smallTitle { "Kotlin Backend фреймворки" }
//            +unorderedListOf(
//                "Spring MVC/Spring Boot",
//                "Ktor",
//                "Quarkus",
//                "Micronaut",
//                "Vert.x",
//
//            )
//        }
    }

    verticalSlide {
        slide {
            +img("spring.svg") {
                height = 200
            }
            +smallTitle { "Spring MVC/Spring Boot" }
        }
        slide {
            +smallTitle { "Spring MVC/Spring Boot" }
            +smallTitle { "JVM Backend фреймворк" }
            +smallTitle { "по умолчанию" }
        }
        slide {
            +img("web-framework-popular.png") {
                stretch = true
            }
        }
        slide {
            +smallTitle { "Преимущества" }
            +unorderedListOf(
                "Богатая экосистема",
                "Функционал из коробки",
                "Распространённость",
                "Хорошая документация",
                fragmented = false,
            )
        }
        slide {
            +smallTitle { "Недостатки" }
            +unorderedListOf(
                "Сложность под капотом",
                "Сложность адаптации под проект",
                "Высокое потребление ресурсов",
                "Долгий старт",
                "Построен на рефлексии",
                "Java-style",
                fragmented = false,
            )
        }
    }

    verticalSlide {
        slide {
            +img("Ktor-icon.svg") {
                height = 200
            }
            +smallTitle { "Ktor" }
        }
        slide {
            +smallTitle { "Ktor" }
            +smallTitle { "Pure-Kotlin HTTP фреймворк" }
            +smallTitle { "от разрабочиков языка" }
        }
        slide {
            +smallTitle { "Преимущества" }
            +unorderedListOf(
                "Kotlin-first",
                "Асинхронный (на корутинах)",
                "Низкое потребление ресурсов",
                "Простой",
                "Есть реализация под Kotlin Native",
                "Хорошая документация",
                "Легкая адаптация",
                fragmented = false,
            )
        }
        slide {
            +smallTitle { "Недостатки" }
            +unorderedListOf(
                "Буквально HTTP сервер и клиент",
                "Всё остальное нужно написать самому",
                fragmented = false,
            )
        }
    }

    verticalSlide {
        slide {
            +img("micronaut.png") {
                height = 200
            }
            +smallTitle { "Micronaut" }
        }
        slide {
            +smallTitle { "Micronaut" }
            +smallTitle { "Переосмысление идей" }
            +smallTitle { "Spring Boot" }
        }
        slide {
            +smallTitle { "Преимущества" }
            +unorderedListOf(
                "Низкое потребление ресурсов",
                "Низкое время запуска",
                "Поддержка реактивности",
                "DI работает на этапе компиляции",
                "Знакомый по Spring Boot подход",
                fragmented = false,
            )
        }
        slide {
            +smallTitle { "Недостатки" }
            +unorderedListOf(
                "Java-style",
                "Фрагментированная документация (но лучше, чем у Quarkus)",
                fragmented = false,
            )
        }
    }

    verticalSlide {
        slide {
            +img("quarkus.png") {
                height = 200
            }
            +smallTitle { "Quarkus" }
        }
        slide {
            +smallTitle { "Quarkus" }
            +smallTitle { "Супербыстрый JVM фреймворк" }
        }
        slide {
            +smallTitle { "Преимущества" }
            +unorderedListOf(
                "Ориентация на нативную компиляцию",
                "Асинхронный/реактивный (поверх Vert.x)",
                "Низкое потребление ресурсов",
                "Низкое время запуска",
                fragmented = false,
            )
        }
        slide {
            +img("quarkus-speed.png") {
                stretch = true
            }
        }
        slide {
            +smallTitle { "Недостатки" }
            +unorderedListOf(
                "Сложный",
                "Фрагментированная документация",
                "Java-style",
                fragmented = false,
            )
        }
    }

    verticalSlide {
        slide {
            +smallTitle { "Vert.x" }
        }
        slide {
            +smallTitle { "Vert.x" }
            +smallTitle { "Событийно-ориентированный фреймворк" }
        }
        slide {
            +smallTitle { "Преимущества" }
            +unorderedListOf(
                "Полностью асинхронный",
                "Интеграция с корутинами",
                "Высокая производтельность",
                "Низкое потребление ресурсов",
                "Низкое время запуска",
                "Кластеризация из коробки",
                "Много готовых интеграций",
                fragmented = false,
            )
        }
        slide {
            +smallTitle { "Недостатки" }
            +unorderedListOf(
                "Сложная когнитивная модель",
                "Очень низкоуровневый",
                fragmented = false,
            )
        }
    }

    verticalSlide {
        slide {
            +smallTitle { "Что для чего выбрать?" }
        }

        slide {
            +smallTitle { "Spring Boot" }
        }
        slide {
            +smallTitle { "Spring Boot" }
            +unorderedListOf(
                "Найти работу",
                "Быстро выдать готовое решение",
            )
        }

        slide {
            +smallTitle { "Micronaut и Quarkus" }
        }
        slide {
            +smallTitle { "Micronaut и Quarkus" }
            +unorderedListOf(
                "Когда перерос Spring Boot, но нравится его парадигма",
            )
        }

        slide {
            +smallTitle { "Ktor" }
        }
        slide {
            +smallTitle { "Ktor" }
            +unorderedListOf(
                "Микросервисы",
                "Встраиваемый веб-сервер",
            )
        }

        slide {
            +smallTitle { "Vert.X" }
        }
        slide {
            +smallTitle { "Vert.X" }
            +unorderedListOf(
                "Нужна максимальная пропускная способность",
                "Знаешь, что делаешь",
                "Иначе лучше взять Quarkus",
            )
        }
    }

    slide {
        +title { "Ссылка на презентацию и полезные штуки" }
        +qr("https://github.com/LimeBeck/kotlin-backend-presentation")
    }
}

fun kotlinCode(
    id: ID = UuidGenerator.generateId(),
    lines: String? = null,
    block: () -> String,
) = Code(id = id, lang = "kotlin", lines = lines, codeProvider = block)

fun javaCode(
    id: ID = UuidGenerator.generateId(),
    lines: String? = null,
    block: () -> String,
) = Code(id = id, lang = "java", lines = lines, codeProvider = block)

fun qr(data: String) =
    qrCode(data) {
        stretch = true
        transformBuilder {
            val logo = loadAsset("logo2.png")
            it
                .withSize(20)
                .withColor(Colors.css("#B125EA"))
                .withBackgroundColor(Colors.css("#191919"))
                .withLogo(logo, 150, 150, clearLogoArea = true)
        }
    }
