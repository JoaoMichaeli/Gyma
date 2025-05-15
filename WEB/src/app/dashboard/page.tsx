import Navbar from "@/components/navbar";
import Image from "next/image"
import Link from "next/link"
import { Check, ChevronLeft, ChevronRight } from "lucide-react"

export default function DashBoardPage() {
  return (
    <div className="flex flex-col min-h-screen">
        <Navbar active="Dashboard"/>

      <main>
        <section className="py-12 px-4">
          <div className="container mx-auto grid md:grid-cols-2 gap-8 items-center">
            <div>
              <h1 className="text-4xl font-bold leading-tight mb-4">
                Transforme seus treinos e alcance resultados extraordinários com Gyma
              </h1>
              <p className="mb-4 text-2xl">
                Seja você iniciante ou avançado, nosso programa é projetado para mapear seu perfil e cada treino é
                adaptado aos seus objetivos,
                <span className="font-bold">
                  {" "}
                  garantindo um caminho eficiente para a conquista de um corpo mais forte e saudável.
                </span>
              </p>
              <Link
                href="/exercises"
                className="inline-flex items-center bg-[#16a34a] text-white px-4 py-3 rounded-md font-medium text-3xl mx-6"
              >
                <Check className="mr-2 h-5 w-5" /> Acesse seu treino
              </Link>
            </div>
            <div className="relative rounded-lg overflow-hidden">
              <Image
                src="/imagens/lulaTreinos.png"
                alt="Pessoa treinando"
                width={600}
                height={400}
                className="object-cover w-full h-full"
              />
            </div>
          </div>
        </section>

        <section className="py-6 px-4">
          <div className="container mx-auto flex items-center gap-4">
            <div className="flex -space-x-2">
                  <Image
                    src="/imagens/usuariosList.png"
                    alt="lista pessoas"
                    width={355}
                    height={74}
                    className="object-cover"
                  />
            </div>
            <div>
              <p className="font-bold text-2xl">+00001</p>
              <p className="text-1x1">Usuários</p>
            </div>
          </div>
        </section>
        <section className="py-12 px-4">
          <div className="container mx-auto grid md:grid-cols-2 gap-8 items-center">
            <div className="relative">
              <Image
                src="/imagens/celularLayout.png"
                alt="App Showcase"
                width={400}
                height={600}
                className="object-contain mx-auto"
              />
            </div>
            <div>
              <p className="text-[#16a34a] font-medium mb-2 text-3xl">CONHEÇA O GYMA</p>
              <h2 className="text-3xl font-bold mb-4">O seu parceiro perfeito de treino na palma da sua mão.</h2>
              <div className="w-16 h-1 bg-[#16a34a] mb-6"></div>

              <p className="mb-4 text-2xl">Treine com confiança, onde quer que esteja!</p>

              <p className="mb-4 font-semibold text-2xl">Com mais de 20 recursos inteligentes, o Gymnamic orienta enquanto você se exercita.</p>

              <p className="mb-4 text-2xl">
                Com apenas alguns toques, você obtém um programa personalizado com base em seus objetivos.
                Descubra novas práticas de musculação projetadas para levar seus resultados a novos patamares.
              </p>
            </div>
          </div>
        </section>

        <section className="bg-[#1e293b] text-white py-12 px-4">
          <div className="container mx-auto grid md:grid-cols-2 gap-8 items-center">
            <div>
              <p className="text-[#16a34a] text-5xl mb-2">Gyma automatiza tudo!</p>
              <h2 className="text-2xl font-medium mb-2">
                Mais que um treino, uma experiência que
                <span className="font-bold"> redefine seu corpo de forma rápida e eficaz.</span>
              </h2>
            </div>
            <div className="flex justify-end">
              <Link
                href="/exercises"
                className="inline-flex items-center bg-[#16a34a] text-white px-8 py-4 rounded-md text-4xl font-medium"
              >
                Acesse seu treino
              </Link>
            </div>
          </div>
        </section>

        <section className="bg-[#020617] text-white py-12 px-4">
          <div className="container mx-auto">
            <h2 className="text-3xl font-bold text-center mb-8">
              Conheça todos os benefícios do
              <br />
              Gyma nas suas atividades físicas.
            </h2>
            <div className="w-16 h-1 bg-white mx-auto mb-12"></div>

            <div className="relative">
              <div className="flex overflow-hidden gap-6 justify-center">
                {[1, 2, 3].map((item) => (
                  <div key={item} className="w-64 h-52 bg-[#1e293b] rounded-lg p-2 flex-shrink-0">
                    <div className="w-full h-full bg-[#d9d9d9] rounded"></div>
                  </div>
                ))}
              </div>

              <button className="absolute left-0 top-1/2 -translate-y-1/2 w-10 h-10 bg-[#1e293b] rounded-full flex items-center justify-center">
                <ChevronLeft className="w-6 h-6" />
              </button>

              <button className="absolute right-0 top-1/2 -translate-y-1/2 w-10 h-10 bg-[#1e293b] rounded-full flex items-center justify-center">
                <ChevronRight className="w-6 h-6" />
              </button>
            </div>
          </div>
        </section>
      </main>

      <footer className="bg-[#020617] text-white py-8 px-4 mt-auto">
        <div className="container mx-auto grid grid-cols-1 md:grid-cols-3 gap-8">
          <div>
            <h3 className="font-bold mb-4">Sobre nós</h3>
            <ul className="space-y-2">
              <li>
                <Link href="#" className="hover:text-[#e2e8f0]">
                  Conheça o Gyma
                </Link>
              </li>
              <li>
                <Link href="#" className="hover:text-[#e2e8f0]">
                  Central de Ajuda
                </Link>
              </li>
              <li>
                <Link href="#" className="hover:text-[#e2e8f0]">
                  Redes sociais
                </Link>
              </li>
            </ul>
          </div>

          <div>
            <h3 className="font-bold mb-4">Produtos</h3>
            <ul className="space-y-2">
              <li>
                <Link href="#" className="hover:text-[#e2e8f0]">
                  Treinos personalizados
                </Link>
              </li>
              <li>
                <Link href="#" className="hover:text-[#e2e8f0]">
                  Acompanhamentos
                </Link>
              </li>
              <li>
                <Link href="#" className="hover:text-[#e2e8f0]">
                  Guias
                </Link>
              </li>
            </ul>
          </div>

          <div>
            <h3 className="font-bold mb-4">Termos</h3>
            <ul className="space-y-2">
              <li>
                <Link href="#" className="hover:text-[#e2e8f0]">
                  Termos e condições
                </Link>
              </li>
              <li>
                <Link href="#" className="hover:text-[#e2e8f0]">
                  Política de Cookies
                </Link>
              </li>
              <li>
                <Link href="#" className="hover:text-[#e2e8f0]">
                  Aviso de privacidade
                </Link>
              </li>
            </ul>
          </div>
        </div>
      </footer>
    </div>
  )
}

