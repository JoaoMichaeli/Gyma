'use client';
import Link from "next/link";

interface NavbarProps {
    active: "Dashboard" | "Treinos" | "Check-in" | "Login";
}

export default function Navbar(props: NavbarProps) {
    const { active } = props;
    const activeClass = "border-b-2 border-green-600 pb-4";

    const link = [
        { link: "/dashboard", label: "Dashboard" },
        { link: "/exercises", label: "Treinos" },
        { link: "/checkin", label: "Check-in" },
        { link: "/login", label: "Login" }
    ];

    return (
        <nav className="flex px-6 pt-6 pb-4 justify-between items-center bg-slate-900">
            <h1 className="text-4xl font-bold text-white mb-4">Gyma</h1>
            <ul className="hidden md:flex gap-6 text-xl text-white">
                {link.map((link) => (
                    <li
                        key={link.label}
                        className={link.label === active ? activeClass : ""}
                    >
                        <Link href={link.link}>{link.label}</Link>
                    </li>
                ))}
            </ul>
            <img
                className="size-12 rounded-full hover:scale-105 transition-transform duration-300"
                src="/imagens/lulaIcon.png"
                alt="User Profile"
                aria-label="User Profile"
            />
        </nav>
    );
}